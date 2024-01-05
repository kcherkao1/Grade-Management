package com.example.miniprojgl.model;

public class User {
    private int id;
    private String username;
    private String password;
    private String email;
    public String role; // Added role field

    // Default constructor
    public User() {
    }

    // Constructor with all fields
    public User(int id, String username, String password, String email, String role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
    }

    // Constructor without role field
    public User(int id, String username, String password, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = "user"; // Default role
    }

        // Getters and setters for all fields
        public int getId () {
            return id;
        }

        public void setId ( int id){
            this.id = id;
        }

        public String getUsername () {
            return username;
        }

        public void setUsername (String username){
            this.username = username;
        }

        public String getPassword () {
            return password;
        }

        public void setPassword (String password){
            this.password = password;
        }

        public String getEmail () {
            return email;
        }

        public void setEmail (String email){
            this.email = email;
        }

        public String getRole () {
            return role;
        }

        public void setRole (String role){
            this.role = role;
        }

        // toString method, if needed
        @Override
        public String toString () {
            return "User{" +
                    "id=" + id +
                    ", username='" + username + '\'' +
                    ", password='" + password + '\'' +
                    ", email='" + email + '\'' +
                    ", role='" + role + '\'' +
                    '}';
        }
    }

