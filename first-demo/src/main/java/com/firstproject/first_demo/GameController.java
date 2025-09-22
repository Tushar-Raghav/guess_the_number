package com.firstproject.first_demo;

import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class GameController {

@Autowired 
private GameSessionRepository GameSessionRepo;

 @PostMapping("/")
    public String saveGameSession(@RequestBody String userName) {
        int randomNumber = generateGuessingNumber();
        GameSessionDocument gameSession = new GameSessionDocument(randomNumber, userName);
        GameSessionDocument gameSessionRes = this.GameSessionRepo.save(gameSession);
        System.out.println("<saveGameSession>   RES  :: " + gameSessionRes.toString());
        return gameSessionRes.getGameId();
    }

 @GetMapping("/")
 public String checkNumber(@RequestParam int guessedNumber,@RequestParam String gameId) {
    System.out.println("< checkNumber >   guessedNumber :: " + guessedNumber + "  gameId  :: " + gameId);
    String resMessage = "Game Session Not Found";
    if(GameSessionRepo.existsById(gameId)){

        Optional<GameSessionDocument> optionalGameSession = GameSessionRepo.findById(gameId);
           // If the game session is not found, return a message
        return optionalGameSession.map(gameSession -> {
            System.out.println("< checkNumber > Game session :: " + gameSession.getGuessingNumber());
            int guessingNumber = gameSession.getGuessingNumber();
            if(guessedNumber > guessingNumber){
                return "You are too High! Please Guess Again";
            }else if(guessedNumber < guessingNumber){
                return "You are too Low! Please Guess Again";
            }else{
                gameSession.setIsGameFinished(true);
                GameSessionRepo.save(gameSession);
                return "Congrats! You Won";
            }
            
        }).orElse("Game session not found!"); 
    }
     return resMessage;
 }
 














    // Method to generate a random guessing number
    private int generateGuessingNumber() {
        Random random = new Random();
        return random.nextInt(100) + 1; // Random number between 1 and 100
    }

}
