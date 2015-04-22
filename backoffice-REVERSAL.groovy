import groovy.json.JsonSlurper

public static String backofficeOperation() {
  def url = "https://test.oppwa.com/v1/payments/8a8294494cdc8e92014ce05940cf043c".toURL()
  def connection = url.openConnection()

  connection.setRequestMethod("POST")
  connection.doOutput = true
  String data ="authentication.userId=8a8294174b7ecb28014b9699220015cc" +
          "&authentication.password=sy6KJsT8" +
          "&authentication.entityId=8a8294174b7ecb28014b9699a3cf15d1" +
          "&paymentType=RV"
  connection.outputStream << data
  def json = new JsonSlurper().parseText(connection.inputStream.text)
  json
}
println backofficeOperation()