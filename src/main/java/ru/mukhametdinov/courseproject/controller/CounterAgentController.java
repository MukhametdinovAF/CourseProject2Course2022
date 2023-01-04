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

import java.util.Optional;

@Slf4j
@Controller
public class CounterAgentController {
    @Autowired
    private CounterAgentRepository counterAgentRepository;

    @GetMapping("/list")
    public ModelAndView gelAllCounterAgents() {
        log.info("/list->connection");
        ModelAndView mav = new ModelAndView("list-counteragents");
        mav.addObject("counteragents", counterAgentRepository.findAll());
        return mav;
    }

    @GetMapping("/addCounterAgentsForm")
    public ModelAndView addCounterAgentsForm() {
        ModelAndView mav = new ModelAndView("add-counteragent-form");
        CounterAgent counterAgent = new CounterAgent();
        mav.addObject("counteragent", counterAgent);
        return mav;
    }

    @PostMapping("/saveCounterAgent")
    public String saveCounterAgent(@ModelAttribute CounterAgent counterAgent) {
        counterAgentRepository.save(counterAgent);
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
        return mav;
    }

    @GetMapping("/deleteCounterAgent")
    public String deleteCounterAgent(@RequestParam Long counterAgentId) {
        counterAgentRepository.deleteById(counterAgentId);
        return "redirect:/list";
    }

}
