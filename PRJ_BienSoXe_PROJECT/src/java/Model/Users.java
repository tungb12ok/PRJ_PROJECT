/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import lombok.Data;

@Data
public class Users {
    String username;
    String password;
    String name;
    String role;
    boolean status;
}
