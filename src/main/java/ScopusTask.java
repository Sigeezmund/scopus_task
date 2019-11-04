import ru.scopus.service.HttpInfoServiceImpl;
import ru.scopus.service.WorkWithIdService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ScopusTask {

    public static void main(String[] args) {

        List<Long> authorsId = new ArrayList<Long>(Arrays.asList(7005686056L, 7005686057L, 7005686070L, 7005686088L, 7005686080L));

        WorkWithIdService workWithIdService = new WorkWithIdService(new HttpInfoServiceImpl());
        workWithIdService.workWithAuthors(authorsId);
    }
}
