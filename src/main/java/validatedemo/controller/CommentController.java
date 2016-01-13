package validatedemo.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import validatedemo.aop.ValidateEntry;
import validatedemo.po.CommentDTO;
import validatedemo.util.ErrorHelper;


@Controller
public class CommentController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CommentController.class);

    @Autowired
    private ErrorHelper errorHelper;
    
    @RequestMapping(value = "/api/comment", method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public Object addcomment( @Valid @RequestBody CommentDTO commentDTO) {
        LOGGER.debug("Received comment: {}", commentDTO);
        return commentDTO;
    }
    
    @ValidateEntry
    @RequestMapping(value = "/api/getcomment", method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public CommentDTO getcomment( @Valid  CommentDTO commentDTO,BindingResult result) /*throws Exception*/{
        LOGGER.debug("get Received comment: {}", commentDTO);
        /*if ( result.hasErrors() ){
            throw new ValidatorException("验证异常", errorHelper.converBindError2AjaxError(result));
        }*/
        new CommentDTO();
        return commentDTO;
    }
    

}
