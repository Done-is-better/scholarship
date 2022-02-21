export interface ILogin{
  data:IData,
  [propName:string]:any
}
export interface IData{
  data:IObj,
  [propName:string]:any
}
export interface IObj{
  id:number,
  [propName:string]:any
}
