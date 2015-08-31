import groovy.json.JsonSlurper

public static String request() {
  def data = "authentication.userId=8a8294174b7ecb28014b9699220015cc" +
    "&authentication.password=sy6KJsT8" +
    "&authentication.entityId=8a8294174b7ecb28014b9699220015ca" +
    "&amount=92.00" +
    "&currency=EUR" +
    "&paymentBrand=AMEX" +
    "&paymentType=PA" +
    "&card.number=377777777777770" +
    "&card.holder=Jane Jones" +
    "&card.expiryMonth=05" +
    "&card.expiryYear=2018" +
    "&card.cvv=1234"
  def url = "https://test.oppwa.com/v1/payments".toURL()
  def connection = url.openConnection()
  connection.setRequestMethod("POST")
  connection.doOutput = true
  connection.outputStream << data
  def json = new JsonSlurper().parseText(connection.inputStream.text)
  json
}
println request()
