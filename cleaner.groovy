
def buildCheker = [:]

node('master'){
  checkout scm
  buildCheker['size'] = sh(returnStdout: true, script: '''df -h | grep fscoding |awk '{print $5 + ""}' ''' )

  if (buildCheker['size'].toInteger() > 80) {
    println('Starting the clean up')
  } else {
    println("The disk usage below 80% nothing to clean")
  }
}
