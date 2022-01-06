package com.example.User.Controller;

import com.example.User.Model.BankUser;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

import static java.lang.Double.parseDouble;


@RestController
public class UserController {

    ArrayList<BankUser> user = new ArrayList<>();

    @GetMapping("/users")
    public ArrayList <BankUser>GetUser(){
        return user;
    }

    @PostMapping("/users")
    public ResponseEntity <String> adduser(@RequestBody BankUser bankUser) {

        if (bankUser.getId() == null) {
            return ResponseEntity.status(400).body("please enter all filed");
        }
        if (bankUser.getPassword().length()<=6){
            return ResponseEntity.status(400).body(" your pass lase than 6  ");
        }
        for (int i = 0; i < user.size(); i++) {

            if ( user.get(i).getEmail().equals(bankUser.getEmail())){
                return ResponseEntity.status(400).body("change your Emil");
            }
            if (bankUser.getLonAmount() == 0){
                return ResponseEntity.status(400).body(" error");

            }
            
        }
       user.add(bankUser);
        return ResponseEntity.status(200).body("add");
    }
   @PostMapping("/add/{id}")
   private ResponseEntity addMonye( @PathVariable String id , @RequestBody String balance   ) {

    for (int i = 0; i <user.size() ; i++) {

        if (id.equals(user.get(i).getId()))
        {
            user.get(i).setBalance(parseDouble(balance) + user.get(i).getBalance());
            return ResponseEntity.status(200).body("Add successfully");
        }

    }
    return ResponseEntity.status(400).body("user not found");
    }

    @PostMapping("/Deposit/{id}")
    private ResponseEntity Deposit( @PathVariable String id , @RequestBody String balance   ) {

        for (int i = 0; i <user.size() ; i++) {

            if (id.equals(user.get(i).getId()))
            {

                user.get(i).setBalance(user.get(i).getBalance()-parseDouble(balance) );

                return ResponseEntity.status(200).body("Add successfully");
            }
        }
        return ResponseEntity.status(400).body("user not found");
    }

    @PostMapping("/lon/{id}")
    private ResponseEntity Lon( @PathVariable String id , @RequestBody String lonAmount   ) {

        for (int i = 0; i <user.size() ; i++) {

            if (id.equals(user.get(i).getId()))
            {

                user.get(i).setLonAmount(parseDouble(lonAmount) + user.get(i).getBalance());

                return ResponseEntity.status(200).body("Add successfully");
            }
        }
        return ResponseEntity.status(400).body("user not found");
    }


    @PutMapping("/users/{id}")
    public ResponseEntity <String> upde( @RequestBody BankUser bankUser , @PathVariable("id") String id) {

        boolean isFuond = false;
        for (int i = 0; i < user.size(); i++) {
            if (user.get(i).getId().equals(id)) {
                user.set(i, bankUser);
                isFuond = true;
                break;
            }
        }

        if (!isFuond){
            return ResponseEntity.status(400).body("please enter all feild");
        }
        return ResponseEntity.status(200).body("User apdeted");
        }




    @DeleteMapping("/users/{id}")
    public ResponseEntity <String> DeleteAccount ( @RequestBody BankUser bankUser ,@PathVariable("id") String id) {
        boolean isFuond = false;
        for (int i = 0; i < user.size(); i++) {
            if (user.get(i).getId().equals(id)) {
                user.remove(i);
                isFuond = true;
                break;
            }
        }
        if (!isFuond) {
            return ResponseEntity.status(400).body("please enter all feild");
        }
        return ResponseEntity.status(200).body("User Deleted");
    }























//    ArrayList<Users> user = new ArrayList<>();
//
//        @GetMapping("/users")
//        public ArrayList <Users>GetUser(){
//            return user;
//        }
//
//
//        @PostMapping("/users")
//        public ResponseEntity adduser(@RequestBody Users users){
//            if (users.getId()==null  ){
//                return ResponseEntity.status(400).body("please enter all feild");
//            }
//            if (users.getPassword() <= ){
//                return ResponseEntity.status(400).body("Enter passord more than 6");
//            }
//           user.add(users);
//         return ResponseEntity.status(200).body("User created");
//        }
//
//
//        @PutMapping("/users/{id}")
//        public ResponseEntity <String> upde( @RequestBody Users users ,@PathVariable("id") String id){
//
//            boolean isFuond =false;
//            for (int i = 0; i < user.size(); i++) {
//                if(user.get(i).getId().equals(id)){
//                    user.set(i,users);
//                    isFuond=true;
//                    break;
//                }
//            }
//            if (!isFuond){
//                return ResponseEntity.status(400).body("please enter all feild");
//            }
//            return ResponseEntity.status(200).body("User apdeted");
//        }
//
//
//        @DeleteMapping("/users/{id}")
//        public String Delete(@PathVariable("id") String id) {
//
//            user.remove(id);
//
//            return "deleted";
//        }
//
//
//        public boolean check(Users users){
//            if(users.getId()==null){
//
//                return false;
//            }
//            return true;
//        }
        }