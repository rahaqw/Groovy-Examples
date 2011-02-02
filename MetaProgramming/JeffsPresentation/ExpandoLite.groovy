class ExpandoLite {

    private dynamicProperties = [:]

    void setProperty(String name, value) {
        dynamicProperties[name] = value
    }

    def getProperty(String name) {
        dynamicProperties[name]
    }

}
