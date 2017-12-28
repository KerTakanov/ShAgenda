package com.pfcca.controllers;

import com.pfcca.models.DateContainer;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

@Controller
@PreAuthorize("hasAuthority('RESPONSABLE')")
@RequestMapping("/agenda")
public class AgendaController {
    @RequestMapping()
    String getIndex(Model model) {
        model.addAttribute("agendadate", new DateContainer());
        return "agenda/index";
    }

    @RequestMapping(method = RequestMethod.POST)
    String getAgenda(@ModelAttribute DateContainer agendadate, Model model) {
        model.addAttribute("agendadate", agendadate);
        return "agenda/index";
    }
}
