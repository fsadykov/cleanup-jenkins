
def emailer(){
  println(''' Hello everyon,
  Our jenins is out of space. Pleas take a look the jenkins server
  Thank you ''')
}

def buildCheker = [:]
def commonEmail = emailer()



node('master'){
  checkout scm
  buildCheker['size'] = sh(returnStdout: true, script: '''df -h | grep fscoding |awk '{print $5 + ""}' ''' )

  if (buildCheker['size'].toInteger() > 10) {
    commonEmail()
  } else {
    println("The disk usage below 80% nothing to clean")
  }
}
