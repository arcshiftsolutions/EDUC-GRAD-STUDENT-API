package ca.bc.gov.educ.api.gradstudent.endpoint;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ca.bc.gov.educ.api.gradstudent.struct.GradStudent;
import ca.bc.gov.educ.api.gradstudent.util.EducGradStudentApiConstants;

@RequestMapping(EducGradStudentApiConstants.GRAD_STUDENT_API_ROOT_MAPPING)
public interface GradStudentEndpoint {

    /**
     * Gets Student details by pen.
     *
     * @param pen the pen
     * @return the student details by pen
     */
    @GetMapping(EducGradStudentApiConstants.GRAD_STUDENT_BY_PEN)
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
    List<GradStudent> getGradStudentByLastNameAndFirstName(
    		@RequestParam(value = "lastName", required = false,defaultValue = "*") String lastName,
    		@RequestParam(value = "firstName", required = false,defaultValue = "*") String firstName,
    		@RequestParam(value = "pageNo", required = false,defaultValue = "0") Integer pageNo, 
            @RequestParam(value = "pageSize", required = false,defaultValue = "50") Integer pageSize);
    
    @GetMapping(EducGradStudentApiConstants.GRAD_STUDENT_BY_MULTIPLE_PENS)
    List<GradStudent> getGradStudentByPens(@RequestParam(value = "penList", required = true) List<String> penList);
    

}
