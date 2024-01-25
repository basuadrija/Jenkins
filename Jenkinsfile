
@Library('my-shared-library') _
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
    
