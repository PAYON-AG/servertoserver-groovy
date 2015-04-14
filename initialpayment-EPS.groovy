import groovy.json.JsonSlurper

public static String initialPayment() {
  def url = "https://test.oppwa.com/v1/payments".toURL()
  def connection = url.openConnection()

  connection.setRequestMethod("POST")
  connection.doOutput = true
  String data ="authentication.userId=8a8294174b7ecb28014b9699220015cc" +
          "&authentication.password=sy6KJsT8" +
          "&authentication.entityId=8a8294184c0378fe014c046e80340da9" +
          "&amount=12.03" +
          "&currency=EUR" +
          "&paymentBrand=EPS" +
          "&paymentType=PA" +
          "&bankAccount.country=AT" +
          "&shopperResultUrl=https://docs.oppwa.com"

  connection.outputStream << data
  def json = new JsonSlurper().parseText(connection.inputStream.text)
  json
}

println initialPayment()