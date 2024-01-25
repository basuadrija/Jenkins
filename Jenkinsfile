pipeline{
    agent any
    stages {
        stage('git Checkout'){
            steps{
                script{
                    gitCheckout(
                        branch: "master"
                        url: "https://github.com/basuadrija/Jenkins.git"
                    )
                }
            }
        

        stage('Unit Test Maven'){
            steps{
                script{
                    mvnTest()
                }
            }
        }

        stage('Integration Test Maven'){
            steps{
                script{
                    mvnIntegrationTest()
                }
            }
        }

        }
    }
