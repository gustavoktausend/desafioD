import axios from 'axios';

const get = url => axios.get(url);

const post = (url, params) => axios.post(url,params);

class Api {
    constructor(baseUrl = '' ) {
        this.baseUrl = baseUrl;
    }

    get = () => get(`${this.baseUrl}`);
    create = params => post(this.baseUrl, params);
}

class LancheApi extends Api{
    constructor() {
        super('http://localhost:8080/api/lanche')
    }

    getAllIngredientes = () => get(`${this.baseUrl}/ingredientes`)


}
export const lancheApi = new LancheApi();