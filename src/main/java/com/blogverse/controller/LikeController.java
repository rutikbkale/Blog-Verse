
import com.blogverse.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
//@RequestMapping("/like")
public class LikeController {

    @Autowired
    private LikeService service;

    @RequestMapping(value = "/doLike", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public int doLike(@RequestParam int postId, @RequestParam int userId) {
        if (service.isLikedPostByUserId(postId, userId)) {
            service.deleteLike(postId, userId);
        } else {
            service.addLike(postId, userId);
        }
        return service.getCountByPostId(postId);
    }
}
