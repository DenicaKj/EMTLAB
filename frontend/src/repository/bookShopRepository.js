import axios from "../custom-axios/axios";

const BookShopService={
    fetchBooks:()=>{
        return axios.get("/books");
    }
}

export default BookShopService;