export interface IHome{
  swiper: ISwiper[],
  nav: INav[]
  [propsName:string]:any
}

export interface ISwiper{
  url:string
}
export interface INav{
  url?:string,
  [propsName:string]:any
}
