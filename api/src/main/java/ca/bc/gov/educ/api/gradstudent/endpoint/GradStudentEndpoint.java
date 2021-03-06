package ca.bc.gov.educ.api.gradstudent.endpoint;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ca.bc.gov.educ.api.gradstudent.struct.GradStudent;
import ca.bc.gov.educ.api.gradstudent.util.EducGradStudentApiConstants;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RequestMapping(EducGradStudentApiConstants.GRAD_STUDENT_API_ROOT_MAPPING)
@OpenAPIDefinition(info = @Info(title = "API for Student Demographics.", description = "This Read API is for Reading demographics data of a student.", version = "1"), security = {@SecurityRequirement(name = "OAUTH2", scopes = {"READ_GRAD_STUDENT_DATA"})})
public interface GradStudentEndpoint {

    /**
     * Gets Student details by pen.
     *
     * @param pen the pen
     * @return the student details by pen
     */
    @GetMapping(EducGradStudentApiConstants.GRAD_STUDENT_BY_PEN)
    @PreAuthorize("#oauth2.hasScope('READ_GRAD_STUDENT_DATA')")
    GradStudent getGradStudentByPen(@PathVariable String pen);
    
    /**
     * Gets Student details by lastname.
     *
     * @param lastName the lastname of a student
     * @param pageNo the page number to return
     * @param pageSize the number of result items in a page
     * @return the student details by pen
     */
    @GetMapping(EducGradStudentApiConstants.GRAD_STUDENT_BY_LAST_NAME)
    @PreAuthorize("#oauth2.hasScope('READ_GRAD_STUDENT_DATA')")
    List<GradStudent> getGradStudentByLastName(
    		@RequestParam(value = "lastName", required = true) String lastName,
    		@RequestParam(value = "pageNo", required = false,defaultValue = "0") Integer pageNo, 
            @RequestParam(value = "pageSize", required = false,defaultValue = "50") Integer pageSize);
    
    /**
     * Gets Student details by first name.
     *
     * @param lastName the first name of a student
     * @param pageNo the page number to return
     * @param pageSize the number of result items in a page
     * @return the student details by pen
     */
    @GetMapping(EducGradStudentApiConstants.GRAD_STUDENT_BY_FIRST_NAME)
    @PreAuthorize("#oauth2.hasScope('READ_GRAD_STUDENT_DATA')")
    List<GradStudent> getGradStudentByFirstName(
    		@RequestParam(value = "firstName", required = true) String firstName,
    		@RequestParam(value = "pageNo", required = false,defaultValue = "0") Integer pageNo, 
            @RequestParam(value = "pageSize", required = false,defaultValue = "50") Integer pageSize);
    
    /**
     * Gets Student details by lastname.
     *
     * @param lastName the lastname of a student
     * @param pageNo the page number to return
     * @param pageSize the number of result items in a page
     * @return the student details by pen
     */
    @GetMapping(EducGradStudentApiConstants.GRAD_STUDENT_BY_ANY_NAME)
    @PreAuthorize("#oauth2.hasScope('READ_GRAD_STUDENT_DATA')")
    List<GradStudent> getGradStudentByLastNameAndFirstName(
    		@RequestParam(value = "lastName", required = false,defaultValue = "*") String lastName,
    		@RequestParam(value = "firstName", required = false,defaultValue = "*") String firstName,
    		@RequestParam(value = "pageNo", required = false,defaultValue = "0") Integer pageNo, 
            @RequestParam(value = "pageSize", required = false,defaultValue = "20") Integer pageSize);
    
    @GetMapping(EducGradStudentApiConstants.GRAD_STUDENT_BY_MULTIPLE_PENS)
    @PreAuthorize("#oauth2.hasScope('READ_GRAD_STUDENT_DATA')")
    List<GradStudent> getGradStudentByPens(@RequestParam(value = "penList", required = true) List<String> penList);
    

}
