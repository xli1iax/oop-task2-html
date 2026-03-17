package oop.zadanie2;

import java.util.Arrays;

public class CityWeb extends AbstractWeb {
    private String[] cities;

    public CityWeb(User[] users, String[] cities) {
        super(users);
        this.cities = cities;
    }

    @Override
    public Response getById(Request request) {
            if (super.authenticate(request)) {
                int index = request.getId();
                if (index >= 0 && index < cities.length) {
                    return  new Response(true, cities[request.getId()]);
                }
            }
            return new Response(false, "");

    }

    @Override
    public Response getAll(Request request) {
            if (authenticate(request)) {
                return new Response(true, String.join(", ", cities));
            }

        return new Response(false, "");
    }

}
