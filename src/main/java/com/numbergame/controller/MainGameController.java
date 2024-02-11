package com.numbergame.controller;

import com.numbergame.service.RandomNumberGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainGameController {

    @Autowired
    PageRedirectController pageRedirect;

    @Autowired
    RandomNumberGeneratorService randomNumberGeneratorService;

    static int randomNumber;

    static int chances;

    static String levelNameRedirect;



    @RequestMapping("beginnerLevelNumber")
    public String newNumberBeginner(Model model){
        randomNumber = RandomNumberGeneratorService.getRandomNumber();
        chances = 10;
        model.addAttribute("RemainingChances","Your "+(chances)+" chances remaining!");
        levelNameRedirect = "beginnerLevel";
        return pageRedirect.beginnerLevel();
    }

    @RequestMapping("intermediateLevelNumber")
    public String newNumberIntermediate(Model model){
        randomNumber = RandomNumberGeneratorService.getRandomNumber();
        chances = 5;
        model.addAttribute("RemainingChances","Your "+(chances)+" chances remaining!");
        levelNameRedirect = "intermediateLevel";
        return pageRedirect.intermediateLevel();
    }


    @RequestMapping("proLevelNumber")
    public String newNumberPro(Model model){
        randomNumber = RandomNumberGeneratorService.getRandomNumber();
        chances = 1;
        model.addAttribute("RemainingChances","Your "+(chances)+" chances remaining!");
        levelNameRedirect = "proLevel";
        return pageRedirect.proLevel();
    }







    @PostMapping({"checkNumberBeginner", "checkNumberIntermediate", "checkNumberPro"})
    public String playGame(Integer numberInput, Model model){

        System.out.println("Your "+(chances)+" chances remaining!");


        try {

            if (numberInput<randomNumber) {
                model.addAttribute("numberCheckingMessage","My guessed number is greater than "+numberInput);
                System.out.println("My guessed number is greater than "+numberInput);
            }
            else if (numberInput>randomNumber) {
                model.addAttribute("numberCheckingMessage","My guessed number is smaller than "+numberInput);
                System.out.println("My guessed number is smaller than "+numberInput);
            }else {
                model.addAttribute("numberCheckingMessage","This is my guessed number");
                model.addAttribute("greenColor","color:green;");
                System.out.println("This is my guessed number");
                throw new Exception();
            }
        }catch (Exception e){

        }
        chances--;
        model.addAttribute("RemainingChances","Your "+(chances)+" chances remaining!");

        switch (levelNameRedirect){
            case "beginnerLevel": return pageRedirect.beginnerLevel();
            case "intermediateLevel" : return pageRedirect.intermediateLevel();
            case "proLevel" : return pageRedirect.proLevel();
        }
        return null;
    }
}
