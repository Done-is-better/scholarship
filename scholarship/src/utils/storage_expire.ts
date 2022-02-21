
export function storageInit(){
  Storage.prototype.setExpire = (key:string,value:{},expire:number) =>{
    const obj = {
      data:value,
      time:Date.now(),
      expire
    }
    //console.log('setexpire 内部')
    localStorage.setItem(key,JSON.stringify(obj))
  }
  Storage.prototype.getExpire = (key:string) =>{
    const val = localStorage.getItem(key)
    if(!val) return val
    const obj = JSON.parse(val)
    if(Date.now() - obj.time > obj.expire){
      localStorage.removeItem(key)
      return null
    }
    return obj.data
  }
}



export const Local = {
  setExpire:(key:string,value:{},expire:number) => localStorage.setExpire(key,value,expire),
  getExpire:(key:string) => localStorage.getExpire(key)
}
