import Big from "big.js";

export class Payment{
  id_payment:number;
  paymentMethod: string;
  date: Date;
  amount: Big;

constructor(id_payment:number,paymentMethod: string, date: Date, amount: Big) {
    this.id_payment=id_payment;
    this.paymentMethod=paymentMethod;
    this.date=date;
    this.amount=amount;
  }
}
