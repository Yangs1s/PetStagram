

const actions = {
    IDCHECK:'IDCHECK',
    PWDCHECK:'PWDCHECK',
    EMAILCHECK:'EMAILCHECK',
    CONFIRMPWDCHECK:'CONFIRMPWDCHECK',
}

export const errorReducer = (alert,action) =>{
    const {EMAILCHECK,IDCHECK,PWDCHECK,CONFIRMPWDCHECK} = actions

    switch(action.type){
        case IDCHECK :{
            return{
                ...alert,
                idAlert:action.idAlert
            }
        } 
        case EMAILCHECK :{
            return{
                ...alert,
                emailAlert:action.emailAlert
            }
        } 
        case PWDCHECK :{
            return{
                ...alert,
                pwdAlert:action.pwdAlert
            }
        } 
        case CONFIRMPWDCHECK :{
            return{
                ...alert,
                confirmPwdAlert:action.confirmPwdAlert
            }
        }
        default:{
            return{
                ...alert,
            }
        }
    }
}