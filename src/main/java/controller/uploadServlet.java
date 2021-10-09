package controller;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/admin/uploadServlet")
@MultipartConfig(maxFileSize = 10*1024*1024)
public class uploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        //获得part对象
        Part part=request.getPart("file");
        String cd = part.getHeader("Content-Disposition");
           //截取不同类型的文件需要自行判断
        String filename = cd.substring(cd.lastIndexOf("=")+2, cd.length()-1);
        if(part==null || filename==""){//上会的文件或文件名为空，提示用户
            request.setAttribute("upload_msg","上传的文件不能为空。");
            request.getRequestDispatcher("/pages/admin/admin_upload.jsp").forward(request,response);
            return;
        }
        String desc = request.getParameter("desc");//获取图片简介
        //指定图片存放的目录为web/upload目录
        File uploadDir=new File(request.getSession().getServletContext().getRealPath("/upload"));
//        File uploadDir=new File(request.getServletContext().getRealPath("/upload"));
        System.out.println(request.getServletContext());

        System.out.println(uploadDir);
        if(!uploadDir.exists()){//目录不存在，则创建
            uploadDir.mkdir();
        }
        String oldName=filename;//取上传的文件名
        //用当前日期时间生成新的文件名
        String newName=new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date());
        //新文件名加上后缀名
        newName+=oldName.substring(oldName.lastIndexOf("."),oldName.length());
        //以下一句 以原文件名保存
        //part.write(uploadDir+File.separator+oldName);
        //以新文件名保存
        part.write(uploadDir+File.separator+newName);
        //判断是否图，不是图片，删除上传的文件，返回
    String path=uploadDir+File.separator+newName;
    if(!isImage(path)){//不是图片
        File file=new File(path);
        if(file.exists()){//文件存在
            file.delete();//删除文件
        }
        request.setAttribute("upload_msg","只能上传图片文件。");
        request.getRequestDispatcher("/pages/admin/admin_upload.jsp").forward(request,response);
        return;
    }
    //如果 要生成缩略图，则调用以下函数
    zoom(uploadDir+File.separator, newName, 100,100);
    //如果 要生成水印，则调用以下方法,生成的带水印的图片文件名为”watermark-“+maxFileSize原来的文件名
    markImageBySingleText(path, uploadDir+File.separator, "watermark-"+newName,Color.red, "文理商场印", null);
    //显示已上传文件的信息，在此目的是测试各个方法的使用，实际应用中可删除
    String msg="上传成功。";
    msg+="<br>"+filename;//上传的文件名
    msg+="<br>"+part.getName();//前端上传控件的名字
    msg+="<br>"+part.getHeader("content-disposition");//content-disposition头信息
    msg+="<br>"+desc;//图片描述
    msg+="<br>"+"上传到："+uploadDir+File.separator+newName;
    request.setAttribute("upload_msg",msg);
    request.getRequestDispatcher("/pages/admin/admin_upload.jsp").forward(request,response);
    return;

}


protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
    //判断 是否是图片,path：文件在服务器上的完整路径
    private boolean isImage(String path){
        //此处读出文件以判断上传的文件是否是png,jpg,bmp,gif图片。也可使用后缀名简单判断。
        boolean isImage=false;
        File file=new File(path);
        try {
            // 通过ImageReader来解码这个file并返回一个BufferedImage对象
            // 如果找不到合适的ImageReader则会返回null，我们可以认为这不是图片文件
            // 或者在解析过程中报错，也返回false
            Image image = ImageIO.read(file);
            return image != null;
        } catch(IOException ex) {
            return false;
        }
    }




//缩放图片，生成缩略图，每一个图片都生成一个大小为100*100的缩略图（可能会失真）。
    // 生成的缩略图名称为原图名称前加上“thumb-”。
    // 如上传后的图片名称为： 2020-04-04-21-04-32-931.jpg，
    // 则缩略图名称为： thumb-2020-04-04-21-04-32-931.jpg 。
    //参数：路径（不带文件名）如”d:/web/upload/“，文件名，缩略图的宽和高
private void zoom(String srcPath, String srcFileName, int width,int height)
    {
        try
        {
            BufferedImage src = ImageIO.read(new File(srcPath+srcFileName));  // 读入源图像
//            int width = src.getWidth();        // 源图宽
//            int height = src.getHeight();        // 源图高
            //  获取一个宽、长是原来scale的图像实例
            Image image = src.getScaledInstance(width, height, Image.SCALE_DEFAULT);
            //缩放图像
            BufferedImage thumb = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            Graphics2D g = thumb.createGraphics();

            g.drawImage(image, 0, 0, null); // 绘制缩小后的图
            g.dispose();

            OutputStream out = new FileOutputStream(srcPath+"thumb-"+srcFileName);
            //取后缀
            String formatName=srcFileName.substring(srcFileName.lastIndexOf(".")+1,srcFileName.length());
            ImageIO.write(thumb, formatName, out);// 输出
            out.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    /**
 * 给图片添加单个文字水印、可设置水印文字旋转角度
 * source 需要添加水印的图片路径（如：F:/images/6.jpg）
 * outPut 添加水印后图片输出路径（如：F:/images/）
 * imageName 图片名称含后缀（如7.jpg） 图片类型(如jpg,bmp,gif,png)
 * color 水印文字的颜色
 * word 水印文字
 * degree 水印文字旋转角度，为null表示不旋转
 */
private Boolean markImageBySingleText(String sourcePath, String outputPath, String imageName,
                                      Color color, String word, Integer degree)
{
    //定义图片水印字体类型
    String FONT_NAME = "微软雅黑";
    //定义图片水印字体加粗、变细、倾斜等样式
    int FONT_STYLE = Font.BOLD;
    //设置字体大小
    int FONT_SIZE = 120;
    //设置文字透明程度
    float ALPHA = 0.3F;
    try {
        //读取原图片信息
        File file = new File(sourcePath);
        if (!file.isFile()) {
            return false;
        }
        //获取源图像的宽度、高度
        Image image = ImageIO.read(file);
        int width = image.getWidth(null);
        int height = image.getHeight(null);
        //获取后缀，不包含”.“，作为图片类型
        String imageType=imageName.substring(imageName.lastIndexOf(".")+1,imageName.length());
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        //创建绘图工具对象
        Graphics2D graphics2D = bufferedImage.createGraphics();
        //其中的0代表和原图位置一样
        graphics2D.drawImage(image, 0, 0, width, height, null);
        //设置水印文字（设置水印字体样式、粗细、大小）
        graphics2D.setFont(new Font(FONT_NAME, FONT_STYLE, FONT_SIZE));
        //设置水印颜色
        graphics2D.setColor(color);
        //设置水印透明度
        graphics2D.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP,ALPHA));
        //设置水印旋转
        if (null != degree) {
            graphics2D.rotate(Math.toRadians(degree),(double) bufferedImage.getWidth() / 2, (double) bufferedImage.getHeight() / 2);
        }
        int x = width/2 - (FONT_SIZE * word.length()/2);
        int y = height/2;
        //进行绘制
        graphics2D.drawString(word, x, y);
        graphics2D.dispose();
        //输出图片
        File sf = new File(outputPath, imageName);
        // 保存图片
        ImageIO.write(bufferedImage, imageType, sf);
    } catch (Exception e) {
        e.printStackTrace();
    }
    return true;
}
}

