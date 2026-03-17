package oop.zadanie2;

public class DayWeb extends AbstractWeb {
    private String[] days = {"pondelok", "utorok", "streda", "stvrtok", "piatok", "sobota", "nedela"};

    public DayWeb(User[] users) {
        super(users);
    }

    @Override
    public Response getById(Request request) {

            if (authenticate(request)) {
                int index = request.getId();
                if (index > 0 && index <= days.length) {
                    return  new Response(true, days[request.getId() - 1]);
                }
            }
                return new Response(false, "");
    }

    @Override
    public Response getAll(Request request) {
        if (authenticate(request)) {
            return new Response(true, String.join(", ", days));
        }
        return new Response(false, "");
    }
}
