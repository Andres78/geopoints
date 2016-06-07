package es.ahs.mygeopoints.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * Created by ahs on 30.05.16.
 */

@Controller
@RequestMapping(value = "/")
public class RootController {

    @RequestMapping(method = RequestMethod.GET)
    public String root() {
        return "redirect:geopoints";
    }

    @RequestMapping(value = "/geopoints", method = RequestMethod.GET)
    public String waybillsList() {
        return "geopoints";
    }

    @RequestMapping(value = "/showPoint", method = RequestMethod.GET)
    public String showPoint(ModelMap model, @RequestParam(value = "id", required = false) Integer id) {
        model.put("id", id);
        return "showPoint";
    }
}
