import Big from "big.js";

export class Game {
    id_game: number;
    title: string;
    genre: string;
    image: string;
    price: Big;
    developer: string;
    stock: number;
    releaseDate: Date;
    idPublisher: number;
    idPlatform: number;
    constructor(
      id_game: number,
        title: string,
        genre: string,
        image: string,
        price: Big,
        developer: string,
        stock: number,
        releaseDate: Date,
        idPublisher: number,
        idPlatform: number
    ) {
        this.id_game = id_game;
        this.title = title;
        this.genre = genre;
        this.image = image;
        this.price = price;
        this.developer = developer;
        this.stock = stock;
        this.releaseDate = releaseDate;
        this.idPublisher = idPublisher;
        this.idPlatform = idPlatform;
    }
}
