import { Box, Typography } from "@mui/material";

import MealCardPlanning from "./MealCardPlanning";

const MealCardPlanningList = () => {
  const meals = [1, 2, 3, 4, 5, 6, 7];

  return (
    <Box
      sx={{
        width: "100%",
      }}
    >
      <Typography
        variant="h5"
        sx={{
          fontWeight: 600,
          mb: 3,
        }}
      >
        Cette semaine
      </Typography>

      <Box
        sx={{
          display: "grid",
          gridTemplateColumns: {
            xs: "1fr",
            sm: "1fr",
            md: "repeat(2, 1fr)",
          },
          gap: 3,
          width: "100%",
        }}
      >
        {meals.map((meal) => (
          <MealCardPlanning key={meal} />
        ))}
      </Box>
    </Box>
  );
};

export default MealCardPlanningList;
