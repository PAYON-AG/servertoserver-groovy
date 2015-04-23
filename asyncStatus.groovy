import groovy.json.JsonSlurper

public static String getPaymentStatus(paymentId) {
  def url = ("https://test.oppwa.com/v1/payments/" + paymentId + 
        "?authentication.userId=8a8294174b7ecb28014b9699220015cc" +
        "&authentication.password=sy6KJsT8" +
        "&authentication.entityId=8a8294174b7ecb28014b9699a3cf15d1").toURL()
  def connection = url.openConnection()
  connection.setRequestMethod("GET")
  
  def json = new JsonSlurper().parseText(connection.inputStream.text)
  json
}

def status = getPaymentStatus("8a8294494ce19bdf014ce509f20b13e7")
println status