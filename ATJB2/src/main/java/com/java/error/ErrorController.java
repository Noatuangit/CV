package com.java.error;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ErrorController {
    @RequestMapping("/error")
    public ModelAndView handleError(HttpServletRequest request) {
        int httpErrorCode = getErrorCode(request);
        ModelAndView modelAndView = new ModelAndView("error/default");
        switch (httpErrorCode) {
            case 400: {
                modelAndView.addObject("error", "400");
                modelAndView.addObject("image",
                        "https://www.eurovps.com/blog/wp-content/uploads/2017/12/69-http-errors-guide-400-hero-1200x450.jpg");
                break;
            }
            case 401: {
                modelAndView.addObject("error", "401");
                modelAndView.addObject("image",
                        "https://cdn.vectorstock.com/i/1000x1000/87/75/website-error-401-authorization-required-artwork-vector-23988775.webp");
                break;
            }
            case 404: {
                modelAndView.addObject("error", "404");
                modelAndView.addObject("image",
                        "https://www.totolink.vn/public/uploads/img_post/truy-tim-nguyen-nhan-va-cach-sua-chua-loi-tra-cuu-404-not-found-1.jpg");
                break;
            }
            case 500: {
                modelAndView.addObject("error", "500");
                modelAndView.addObject("image",
                        "https://ubiq.co/tech-blog/wp-content/uploads/2020/08/apache-500-internal-server-error-730x410.png");
                break;
            }
            case 415: {
                modelAndView.addObject("error", "415");
                modelAndView.addObject("image",
                        "https://vitalflux.com/wp-content/uploads/2014/07/error-415.png?ezimgfmt=ng%3Awebp%2Fngcb1%2Frs%3Adevice%2Frscb1-1");
                break;
            }
            default:
                modelAndView.addObject("error", "Not found!!!");
                modelAndView.addObject("image", "https://cdn-icons-png.flaticon.com/512/2471/2471121.png");
        }
        return modelAndView;
    }

    private int getErrorCode(HttpServletRequest httpRequest) {
        return (Integer) httpRequest.getAttribute("javax.servlet.error.status_code");
    }
}
