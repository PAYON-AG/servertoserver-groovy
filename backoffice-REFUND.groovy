import groovy.json.JsonSlurper

public static String backofficeOperation() {
  def url = "https://test.oppwa.com/v1/payments/8a82944a4cdca5cc014ce058f2003be5".toURL()
  def connection = url.openConnection()

  connection.setRequestMethod("POST")
  connection.doOutput = true
  String data ="authentication.userId=8a8294174b7ecb28014b9699220015cc" +
          "&authentication.password=sy6KJsT8" +
          "&authentication.entityId=8a8294174b7ecb28014b9699a3cf15d1" +
          "&amount=10.00" +
          "&currency=EUR" +
          "&paymentType=RF"
  connection.outputStream << data
  def json = new JsonSlurper().parseText(connection.inputStream.text)
  json
}
println backofficeOperation()