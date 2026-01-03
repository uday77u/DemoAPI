package com.api.base;

public class Data {

    private String firstName;
    private String lastName;
    private String email;
    private String countryENCode;
    private String countryCode;
    private String phone;
    private String DOTNumber;

    // Private constructor
    private Data(Builder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.email = builder.email;
        this.countryENCode = builder.countryENCode;
        this.countryCode = builder.countryCode;
        this.phone = builder.phone;
        this.DOTNumber = builder.DOTNumber;
    }

    // Getters (needed for serialization)
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getEmail() { return email; }
    public String getCountryENCode() { return countryENCode; }
    public String getCountryCode() { return countryCode; }
    public String getPhone() { return phone; }
    public String getDOTNumber() { return DOTNumber; }

    // ✅ Static Builder
    public static class Builder {

        private String firstName;
        private String lastName;
        private String email;
        private String countryENCode;
        private String countryCode;
        private String phone;
        private String DOTNumber;

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder countryENCode(String countryENCode) {
            this.countryENCode = countryENCode;
            return this;
        }

        public Builder countryCode(String countryCode) {
            this.countryCode = countryCode;
            return this;
        }

        public Builder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder DOTNumber(String DOTNumber) {
            this.DOTNumber = DOTNumber;
            return this;
        }

        // ✅ build() method
        public Data build() {
            return new Data(this);
        }
    }
}
