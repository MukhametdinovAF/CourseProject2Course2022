package ru.mukhametdinov.courseproject.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.mukhametdinov.courseproject.entity.CounterAgent;
import ru.mukhametdinov.courseproject.repository.CounterAgentRepository;
import ru.mukhametdinov.courseproject.service.UserActionsService;


import java.util.Optional;

@Slf4j
@Controller
public class CounterAgentController {
    @Autowired
    private CounterAgentRepository counterAgentRepository;
    @Autowired
    private UserActionsService userActionsService;

    public CounterAgentController() {
    }


    @GetMapping("/list")
    public ModelAndView getAllCounterAgents() {
        log.info("/list->connection");
        ModelAndView mav = new ModelAndView("list-counteragents");
        mav.addObject("counteragents", counterAgentRepository.findAll());
        userActionsService.savelog("User get all counteragents");
        return mav;
    }

    @GetMapping("/addCounterAgentsForm")
    public ModelAndView addCounterAgentsForm() {
        ModelAndView mav = new ModelAndView("add-counteragent-form");
        CounterAgent counterAgent = new CounterAgent();
        mav.addObject("counteragent", counterAgent);
        userActionsService.savelog("User adds counteragent");
        return mav;
    }

    @PostMapping("/saveCounterAgent")
    public String saveCounterAgent(@ModelAttribute CounterAgent counterAgent) {
        counterAgentRepository.save(counterAgent);
        userActionsService.savelog("User saves counteragent");
        return "redirect:/list";
    }

    @GetMapping("/showUpdateForm")
    public ModelAndView showUpdateForm(@RequestParam Long counterAgentId) {
        ModelAndView mav = new ModelAndView("add-counteragent-form");
        Optional<CounterAgent> optionalCounterAgent = counterAgentRepository.findById(counterAgentId);
        CounterAgent counterAgent = new CounterAgent();
        if (optionalCounterAgent.isPresent()) {
            counterAgent = optionalCounterAgent.get();
        }
        mav.addObject("counteragent", counterAgent);
        userActionsService.savelog("User see list of counteragents");
        return mav;
    }

    @GetMapping("/deleteCounterAgent")
    public String deleteCounterAgent(@RequestParam Long counterAgentId) {
        counterAgentRepository.deleteById(counterAgentId);
        userActionsService.savelog("User delete counteragent");
        return "redirect:/list";
    }

}
