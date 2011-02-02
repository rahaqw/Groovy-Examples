class ExpandoLite {

    String somePropertyThatHoldsAStatusMessage
    void setProperty(String name, value) {
        somePropertyThatHoldsAStatusMessage = "${name} : ${value}"
    }

}
