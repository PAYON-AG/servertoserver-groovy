import groovy.json.JsonSlurper

public static String registration() {
  def url = "https://test.oppwa.com/v1/registrations".toURL()
  def connection = url.openConnection()

  connection.setRequestMethod("POST")
  connection.doOutput = true
  String data ="authentication.userId=8a8294174b7ecb28014b9699220015cc" +
          "&authentication.password=sy6KJsT8" +
          "&authentication.entityId=8a8294174b7ecb28014b9699a3cf15d1" +
          "&paymentBrand=BRADESCO" +
          "&customer.givenName=Braziliano" +
          "&customer.surname=Babtiste" +
          "&billing.city=Brasilia" +
          "&billing.country=BR" +
          "&billing.state=SP" +
          "&billing.street1=Amazonstda" +
          "&billing.postcode=12345678" +
          "&customParameters[BRADESCO_cpfsacado]=11111111111"
  connection.outputStream << data
  def json = new JsonSlurper().parseText(connection.inputStream.text)
  json
}
println registration()