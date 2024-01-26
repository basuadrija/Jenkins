@Library('my-shared-library') _
pipeline{
    agent any

    parameters {
  choice choices: ['create', 'destroy'], description: 'Choose create or destroy', name: 'action'
}

    stages {

        
        stage('git Checkout'){
            when { expression { params.action == 'create' } }
            steps{
                script{
                    gitCheckout(
                        branch: "master",
                        url: "https://github.com/basuadrija/Jenkins.git"
                    )
                }
           
            }
        }
        

        stage('Unit Test Maven'){
            when { expression { params.action == 'create' } }
            steps{
                script{
                    mvnTest()
                }
            }
        }

        stage('Integration Test Maven'){
            when { expression { params.action == 'create' } }
            steps{
                script{
                    mvnIntegrationTest()
                }
            }
        }

        stage('Static Code Analysis'){
            when { expression { params.action == 'create' } }
            steps{
                script{
                    def SonarQubecredentialsId = 'sonarwithjenkins'
                    staticCodeAnalysis(SonarQubecredentialsId)
                }
            }
        }

        stage('Quality Gate Status Check'){
            when { expression { params.action == 'create' } }
            steps{
                script{
                    def SonarQubecredentialsId = 'sonarwithjenkins'
                    qualityGateStatus(SonarQubecredentialsId)
                }
            }
        }

        stage('Build with  Maven'){
            when { expression { params.action == 'create' } }
            steps{
                script{
                    mvnBuild()
                }
            }
        }

        }
    }
