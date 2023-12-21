import Big from "big.js";
export class UserLibraryView{
  title:string;
  genre:string;
  price:Big;
  developer:string;
  stock:number;
  releaseDate:string;
  discountPercentage:Big;
  startDate:string;
  endDate:string;
  amount:Big;
  paymentMethod:string;
  date:string;
  constructor(
    title:string,
    genre:string,
    price:Big,
    developer:string,
    stock:number,
    releaseDate:string,
    discountPercentage:Big,
    startDate:string,
    endDate:string,
    amount:Big,
    paymentMethod:string,
    date:string,
  ){
      this.title=title;
      this.genre=genre;
      this.price=price;
      this.developer=developer;
      this.stock=stock;
      this.releaseDate=releaseDate;
      this.discountPercentage=discountPercentage;
      this.startDate=startDate;
      this.endDate=endDate;
      this.amount=amount;
      this.paymentMethod=paymentMethod;
      this.date=date;
  }
}
