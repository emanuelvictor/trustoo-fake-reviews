package br.com.lojasgresele.reviews.model;

public class Review {

    private String name;
    private String email;
    private String message;

    private int star;

    public Review(String name, String email, String message, final int star) {
        this.name = name;
        this.email = email;
        this.message = message;
        this.star = star;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getMessage() {
        return message;
    }

    public int getStar() {
        return star;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", message='" + message + '\'';
    }
}
