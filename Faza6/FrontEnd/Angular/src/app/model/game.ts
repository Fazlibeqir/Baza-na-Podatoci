import Big from "big.js";

export class Game {
    id_game: number;
    title: string;
    genre: string;
    price: Big;
    developer: string;
    stock: number;
    releaseDate: Date;
    idPublisher: number;
    constructor(
      id_game: number,
        title: string,
        genre: string,
        price: Big,
        developer: string,
        stock: number,
        releaseDate: Date,
        idPublisher: number,
    ) {
        this.id_game = id_game;
        this.title = title;
        this.genre = genre;
        this.price = price;
        this.developer = developer;
        this.stock = stock;
        this.releaseDate = releaseDate;
        this.idPublisher = idPublisher;
    }
}
