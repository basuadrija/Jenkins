
@Library('my-shared-library@1.0') _
pipeline{
    agent any
    stages {
        stage('git Checkout'){
            steps{
                
                    gitCheckout(
                        branch: "master" ,
                        url: "https://github.com/basuadrija/Jenkins.git"
                    )
                }
            }
        }

        }
    
