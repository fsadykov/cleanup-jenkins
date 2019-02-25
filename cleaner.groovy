
def diskUsage

def checkForCleanUp(){
  diskUsage = sh returnStdout: true, script: ''''df -h | grep fscoding | awk '{print $5 + ""}'''''
}

node('master'){
  if (diskUsage > 80) {
    stage('checking for ') {
      println('I will clean up ')
    }
  } else {
    println("The disk usage below 80% nothing to clean")
  }
}
