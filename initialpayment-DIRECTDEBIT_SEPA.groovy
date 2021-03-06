import groovy.json.JsonSlurper

public static String initialPayment() {
  def url = "https://test.oppwa.com/v1/payments".toURL()
  def connection = url.openConnection()

  connection.setRequestMethod("POST")
  connection.doOutput = true
  String data ="authentication.userId=8a8294174b7ecb28014b9699220015cc" +
          "&authentication.password=sy6KJsT8" +
          "&authentication.entityId=8a8294174b7ecb28014b9699a3cf15d1" +
          "&amount=50.00" +
          "&currency=EUR" +
          "&paymentBrand=DIRECTDEBIT_SEPA" +
          "&paymentType=DB" +
          "&bankAccount.bic=MARKDEF1100" +
          "&bankAccount.iban=DE23100000001234567890" +
          "&bankAccount.country=DE" +
          "&bankAccount.holder=Jane Jones" +
          "&shopperResultUrl=https://docs.oppwa.com"
  connection.outputStream << data
  def json = new JsonSlurper().parseText(connection.inputStream.text)
  json
}

println initialPayment()