def newGit(repo)
{
  git "${repo}"
 
}
def newMaven()
{
   sh 'mvn package'
}
def newDeploy(ip,appname)
{
  deploy adapters: [tomcat9(credentialsId: '48e60a09-4100-4c74-8190-4b1cdfddb272', path: '', url: "${ip}")], contextPath: "${appname}", war: '**/*.war'
}

def newTest(jobname)
{
  echo "${jobname}"
  sh "java -jar /home/ubuntu/.jenkins/workspace/${jobname}/testing.jar"
}
def newDelivery(ip,appname)
{
  deploy adapters: [tomcat9(credentialsId: '388af6fb-6580-4b96-b3e3-c074c4c95cbe', path: '', url: "${ip}")], contextPath: "${appname}", war: '**/*.war'
}
