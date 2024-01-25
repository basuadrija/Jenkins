def call(Map stageParams)
{
    checkout{[
        $class: 'GitSCM'
        branches: [[ name: stageparams.branch ]]
        userRemoteConfigs: [[ url: stageparams.url ]]
    ]}
}
