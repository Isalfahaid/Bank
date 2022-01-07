package com.example.User.Controller;

import com.example.User.Model.Action;
import com.example.User.Model.BankUser;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

import static java.lang.Double.parseDouble;


@RestController
public class UserController {
    ArrayList<BankUser> user = new ArrayList<>();
    int bankBalance = 3000;

    @GetMapping("/users")
    public ArrayList<BankUser> GetUser() {
        return user;
    }

    @PostMapping("/users")
    public ResponseEntity<String> adduser(@RequestBody BankUser bankUser) {

        if (bankUser.getId() == null) {
            return ResponseEntity.status(400).body(" please enter all filed ");
        }
        if (bankUser.getPassword().length() <= 6) {
            return ResponseEntity.status(400).body(" your pass lase than 6 ");
        }
        for (int i = 0; i < user.size(); i++) {
            if (user.get(i).getEmail().equals(bankUser.getEmail())) {
                return ResponseEntity.status(400).body(" change your Emil ");
            }
            if (bankUser.getLonAmount() == 0) {
                return ResponseEntity.status(400).body(" error ");
            }
        }
        user.add(bankUser);
        return ResponseEntity.status(200).body(" add ");
    }

    @PostMapping("/add/{id}")
    private ResponseEntity addMonye(@PathVariable String id, @RequestBody String balance) {

        for (int i = 0; i < user.size(); i++) {
            if (id.equals(user.get(i).getId())) {
                user.get(i).setBalance(parseDouble(balance) + user.get(i).getBalance());
                return ResponseEntity.status(200).body(" Add successfully ");
            }
        }
        return ResponseEntity.status(400).body(" user not found ");
    }

    @PostMapping("/Deposit/{id}")
    private ResponseEntity Deposit(@PathVariable String id, @RequestBody String balance) {

        for (int i = 0; i < user.size(); i++) {
            if (id.equals(user.get(i).getId())) {
                user.get(i).setBalance(user.get(i).getBalance() - parseDouble(balance));
                return ResponseEntity.status(200).body(" Add successfully ");
            }
        }
        return ResponseEntity.status(400).body(" user not found ");
    }

    @PostMapping("/take-loan")
    public ResponseEntity<String> takeLoan(@RequestBody Action action){
        if(action.getId()==null || action.getPassword()==null || action.getAmount() == 0){
            return ResponseEntity.status(400).body("Please send all the fields");
        }

        for (int i = 0; i < user.size(); i++) {
            BankUser u=user.get(i);
            if(u.getId().equals(action.getId())){
                if(!(u.getPassword().equals(action.getPassword()))){
                    return ResponseEntity.status(400).body("Password doesn't match the user id");
                }

                if(bankBalance-action.getAmount()<0){
                    return ResponseEntity.status(400).body("Bank doesn't have money for the transaction");
                }
                bankBalance=bankBalance-action.getAmount();
                double oldLoan=u.getLonAmount();

                double oldBalance=u.getBalance();
                u.setLonAmount(action.getAmount()+oldLoan);
                u.setBalance(action.getAmount()+oldBalance);
                return ResponseEntity.status(200).body(" confirmed");
            }
        }
        return ResponseEntity.status(400).body("Invalid ID");
    }


    @PostMapping("/repay-loan")
    public ResponseEntity<String> repayLoan(@RequestBody Action action){
        if(action.getId()==null || action.getPassword()==null || action.getAmount() == 0){
            return ResponseEntity.status(400).body("Please send all the fields");
        }

        for (int i = 0; i < user.size(); i++) {
            BankUser u=user.get(i);
            if(u.getId().equals(action.getId())){
                if(!(u.getPassword().equals(action.getPassword()))){
                    return ResponseEntity.status(400).body("Password doesn't match the user id");
                }
                if(u.getLonAmount()-action.getAmount()<0){
                    return ResponseEntity.status(400).body("You only have "+u.getLonAmount()+" as loan");
                }
                if(u.getBalance()-action.getAmount()<0){
                    return ResponseEntity.status(400).body("You don't have balance to repay this loan");
                }
                double oldLoan=u.getLonAmount();
                double oldBalance=u.getBalance();
                u.setLonAmount(oldLoan-action.getAmount());
                u.setBalance(oldBalance-action.getAmount());
                bankBalance=bankBalance+action.getAmount();
                return ResponseEntity.status(200).body("Repaying confirmed");
            }
        }
        return ResponseEntity.status(400).body("Invalid ID");
    }





    @PutMapping("/users/{id}")
    public ResponseEntity<String> upde(@RequestBody BankUser bankUser, @PathVariable(" id ") String id) {

        boolean isFuond = false;
        for (int i = 0; i < user.size(); i++) {
            if (user.get(i).getId().equals(id)) {
                user.set(i, bankUser);
                isFuond = true;
                break;
            }
        }
        if (!isFuond) {
            return ResponseEntity.status(400).body(" please enter all feild ");
        }
        return ResponseEntity.status(200).body(" User apdeted ");
    }


    @DeleteMapping("/users/{id}")
    public ResponseEntity<String> DeleteAccount(@RequestBody BankUser bankUser, @PathVariable(" id ") String id) {
        boolean isFuond = false;
        for (int i = 0; i < user.size(); i++) {
            if (user.get(i).getId().equals(id)) {
                user.remove(i);
                isFuond = true;
                break;
            }
        }
        if (!isFuond) {
            return ResponseEntity.status(400).body(" please enter all feild ");
        }
        return ResponseEntity.status(200).body(" User Deleted ");
    }

}




















//        public boolean check(Users users){
//            if(users.getId()==null){
//
//                return false;
//            }
//            return true;
//        }
