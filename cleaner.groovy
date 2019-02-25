
int diskUsage

node('master'){
  diskUsage = sh(returnStdout: true, script: '''df -h | grep fscoding |awk '{print $5 + ""}' ''' )

  println(diskUsage.class)
  if (diskUsage > 80) {
    println('Starting the clean up')
  } else {
    println("The disk usage below 80% nothing to clean")
  }
}
