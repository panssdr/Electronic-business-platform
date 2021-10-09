package controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@Controller
public class PayControllertest {
    private String APP_ID="2016100200644233";
    private String APP_PRIVATE_KEY="MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCAJiYKrkjyqJ6ceBkvcigOaccE1ssXfGEZFsTRisn+351hHIA8t9pP5erqCttXjV7SJGfaY9vRlvBjxcOIuMyp9O6Smlp4K4Ay86blTSxQvnkmnmxAqjwQfS1Wxbn9e1ogv78QjCCR0ayakKFuDsw79F27I5dDQMqzbinChFQu6zvKJatoKr2A1G/pdk+nfPfWgeh+tNDauHp9OjVeX12Bdrkt70XVL8hrbgf8lWVfpDI6q10EHOztTC4oJAK8H1M49w6rAzRkFUW2nfCvobiuJNAWfsaPyJFWhqEFvM+miOdlF1zJxX3ZI1D43fyC2rnazw/4mAyEB3XQg45utSWdAgMBAAECggEAYvAREtH4VBDHVHqMx0rVjjswgpXq+tj2hk5D6pvC1FqEwUMl5rrzfBhAxC1Zp0DoYknlPIE4Z5qnQgCftGEo8la+EsXE7152feALjKGGg1hrZNuPLGXCNeDPLl09+WxQ61PfCcGGK867+iGL4NLf77H848zYrf3KAbod16Ye8JFoUP6Vex9HLUGuM4p0PLuFPYF+zGix5ggMcJKqBZTeKcgW/t6Sl64L394d+F0/oOlWEnFIfewkfFL+aV/ZDjFrfJCv3QsIQmZfLB4NkGdAXY/rKOr4QiNy5/+JRFdbDf+YWC/PV1pX6ff8ti8L3YFGb/vyQInYxPexiulU6Cs8KQKBgQDE76kj9nzw1HFd+Mv4FZslaV2ahl85dO5E/mA017XqRPB27UaMrwcDi3BxkqHdxXk2rdDnbJamVzd64l2aTkquocRDQBhRA0s5tqjT8FvvvX9/kTOcDU9XG1G4NRQk51bkEEDOqddgA69w9AMO9KOxYnQej/5R+on7lTo3p1GRawKBgQCmlSgiaFXS19+/rT/cd2wWezvcKZNqssup6URrmpJRx6D1dwU5OUK5+i20QJa/s3Xg2OvEp82AStvoqyVIAfMnPJ9hEY1kctFs/3SXwEpda/lzPqmZu1qSYWdQ1roiqPXvVmAa1VWq8PyjxQvP/sXP6KdZpt9Hpvbh4yfoI/d/FwKBgEosqlwtPqnGmlx2lPx/xsu0f9jvu3X8oLHDzaCZjp8KEDf67pOWaOHg5x0fyW+qLRl3JjPEJonIV9Ek6XRxAJf9vdpGjeIVh4PZVIVfBoGpshfuLK4eJT/9vi3PcCLmL0f/BynPtpsnSDEW9v/vDKiHGI1aVsOxxb7IWgEUOBi5AoGAF8NtX0MtAw/ijlBjrMqoc6iOyIBx1CW/YfSx2vvI5bupnXqmFxyxBSDIRk90cdJi/XlUYNBjQ2rqZg2MGvKUQkOmpM1BM1Qhxf/HHSLEOQF/K06EGTcd24XjnCeVk/4wXz0eJpXKS8Fm+OHSJpC8nUUeIm7oqSsLSvwBpF8FHm8CgYAbbwQUIKNqdmFOojLJxxcGJOHUZORzbNv6LnRK0XrBabG8DB2abzcObhWlUY51KecvLU6Tn3gFXEz3hYnvI3EjC9P9HJJkU7nQu5vce6QMMUwDdYd0+dCCHf1TUkaupGISOiI/W/Du+19WETix/+uIYChcUosOU5FkwtP8ocy54w==";
    private String FORMAT="JSON";
    private String CHARSET="UTF-8";
    private  String ALIPAY_PUBLIC_KEY="MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAgCYmCq5I8qienHgZL3IoDmnHBNbLF3xhGRbE0YrJ/t+dYRyAPLfaT+Xq6grbV41e0iRn2mPb0ZbwY8XDiLjMqfTukppaeCuAMvOm5U0sUL55Jp5sQKo8EH0tVsW5/XtaIL+/EIwgkdGsmpChbg7MO/RduyOXQ0DKs24pwoRULus7yiWraCq9gNRv6XZPp3z31oHofrTQ2rh6fTo1Xl9dgXa5Le9F1S/Ia24H/JVlX6QyOqtdBBzs7UwuKCQCvB9TOPcOqwM0ZBVFtp3wr6G4riTQFn7Gj8iRVoahBbzPpojnZRdcycV92SNQ+N38gtq52s8P+JgMhAd10IOObrUlnQIDAQAB";
    private String SIGN_TYPE="RSA2";
    private String tradeno;
    private String cash="80";
    //tradeno商户订单号******cash金额

    @RequestMapping("/pay")
    public void pay(HttpServletRequest httpRequest,
                    HttpServletResponse httpResponse) throws ServletException, IOException {
        Date time=new Date();
        long no=time.getTime();
        System.out.println(no);
        tradeno=String.valueOf(no);
        AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipaydev.com/gateway.do", APP_ID, APP_PRIVATE_KEY, FORMAT, CHARSET, ALIPAY_PUBLIC_KEY, SIGN_TYPE); //获得初始化的AlipayClient
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();//创建API对应的request
        alipayRequest.setReturnUrl("http://localhost:8080/index.jsp");
        alipayRequest.setNotifyUrl("http://domain.com/CallBack/notify_url.jsp");//在公共参数中设置回跳和通知地址
        alipayRequest.setBizContent("{" +
                "    \"out_trade_no\":\""+tradeno+"\"," +
                "    \"product_code\":\"FAST_INSTANT_TRADE_PAY\"," +
                "    \"total_amount\":"+cash+"," +
                "    \"subject\":\"Iphone6 16G\"," +
                "    \"body\":\"Iphone6 16G\"," +
                "    \"passback_params\":\"merchantBizType%3d3C%26merchantBizNo%3d2016010101111\"," +
                "    \"extend_params\":{" +
                "    \"sys_service_provider_id\":\"2088511833207846\"" +
                "    }"+
                "  }");//填充业务参数
        String form="";
        try {
            form = alipayClient.pageExecute(alipayRequest).getBody(); //调用SDK生成表单
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        httpResponse.setContentType("text/html;charset=" + CHARSET);
        httpResponse.getWriter().write(form);//直接将完整的表单html输出到页面
        httpResponse.getWriter().flush();
        httpResponse.getWriter().close();
    }

    public class ServletException extends Exception {
    }
}

