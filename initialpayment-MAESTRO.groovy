import groovy.json.JsonSlurper

public static String initialPayment() {
  def url = "https://test.oppwa.com/v1/payments".toURL()
  def connection = url.openConnection()

  connection.setRequestMethod("POST")
  connection.doOutput = true
  String data ="authentication.userId=8a8294174b7ecb28014b9699220015cc" +
          "&authentication.password=sy6KJsT8" +
          "&authentication.entityId=8a8294174b7ecb28014b9699a3cf15d1" +
          "&amount=92.00" +
          "&currency=EUR" +
          "&paymentBrand=MAESTRO" +
          "&paymentType=PA" +
          "&card.number=6799851000000032" +
          "&card.holder=Jane Jones" +
          "&card.expiryMonth=05" +
          "&card.expiryYear=2018" +
          "&card.cvv=123"
  connection.outputStream << data
  def json = new JsonSlurper().parseText(connection.inputStream.text)
  json
}

println initialPayment()