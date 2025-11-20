package com.qaschool;
public class PostValidator {

    public String getPostStatus(String postBody) {
        // 1. Verifica daca este null sau gol
        if (postBody == null || postBody.isEmpty()) {
            return "ERROR_EMPTY";
        }

        // 2. Verifica daca depaseste 250 de caractere
        if (postBody.length() > 250) {
            return "ERROR_TOO_LONG";
        }

        // 3. Verifica daca contine cuvantul "politica"
        if (postBody.contains("politica")) {
            return "ERROR_FORBIDDEN";
        }

        // 4. In toate celalalte cazuri
        return "POST_VALID";
    }
}
